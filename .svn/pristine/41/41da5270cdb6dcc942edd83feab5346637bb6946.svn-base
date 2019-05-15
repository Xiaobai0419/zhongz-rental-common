package com.zhongz.rental.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.zhongz.rental.common.utils.PageUtils;
import com.zhongz.rental.domain.*;
import com.zhongz.rental.mapper.*;
import com.zhongz.rental.param.ZhongzHouseParam;
import com.zhongz.rental.param.ZhongzHouseRentType;
import com.zhongz.rental.param.ZhongzUserOrderParam;
import com.zhongz.rental.result.base.Result;
import com.zhongz.rental.service.IZhongzHouseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 房屋 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
@Service
public class ZhongzHouseServiceImpl implements IZhongzHouseService
{
	@Value("${redis.keys.user}")
	private String userKey;
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	@Autowired
	private ZhongzUserMapper zhongzUserMapper;
	@Autowired
	private ZhongzHouseMapper zhongzHouseMapper;
	@Autowired
	private ZhongzRoomMapper zhongzRoomMapper;
	@Autowired
	private ZhongzEstateMapper zhongzEstateMapper;
	@Autowired
	private ZhongzContractMapper zhongzContractMapper;

	/**
	 * 查询房屋信息
	 *
	 * @param id 房屋id
	 * @return 房屋信息
	 */
	@Override
	public ZhongzHouse selectZhongzHouseById(String id) {
		return zhongzHouseMapper.selectZhongzHouseById(id);
	}

	/**
     * 查询房屋信息
     * 
     * @param zhongzUserOrderParam 房屋用户信息
     * @return 房屋信息
     */
    @Override
	public ZhongzHouse selectZhongzHouseById(ZhongzUserOrderParam zhongzUserOrderParam)
	{
		String houseId = zhongzUserOrderParam.getHouseId();
		ZhongzHouse house = zhongzHouseMapper.selectZhongzHouseById(houseId);
		if(house != null) {
			ZhongzEstate estate = zhongzEstateMapper.selectZhongzEstateById(house.getEstateId());
			house.setEstate(estate);
			//合租房
			if(house.getRentType() == 2) {
				List<ZhongzRoom> rooms = zhongzRoomMapper.selectZhongzRoomByHouseId(house.getId());
				house.setRooms(rooms);
			}
		}
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserOrderParam.getOpenid();
		String sessionKey = zhongzUserOrderParam.getSessionKey();
		//如果是登录用户
		if(StringUtils.isNotBlank(openid) && StringUtils.isNotBlank(sessionKey)) {
			HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
			ZhongzUser user = hashOperations.get(userKey,openid);
			if(user == null) {
				user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
			}
			//查询该用户对该房屋的预约状态订单（合同）
			Integer contractByUserAndHouse = zhongzContractMapper.selectZhongzContractByUserAndHouse(user.getId(),houseId);
			if(contractByUserAndHouse > 0) {
				house.setUserHasOrder(1);
			}
		}
		return house;
	}

	/**
	 * 查询单个房屋租期类别列表
	 *
	 * @param id 房屋ID
	 * @return 单个房屋租期类别列表
	 */
	@Override
	public List<ZhongzHouseRentType> selectZhongzHouseRentTypesById(String id)
	{
		return zhongzHouseMapper.selectZhongzHouseRentTypesById(id);
	}

	/**
     * 查询房屋列表
     * 
     * @param zhongzHouse 房屋信息
     * @return 房屋集合
     */
	@Override
	public List<ZhongzHouse> selectZhongzHouseList(ZhongzHouse zhongzHouse)
	{
	    return zhongzHouseMapper.selectZhongzHouseList(zhongzHouse);
	}

	/**
	 * 查询某用户有效租期内房屋列表（需要登录）
	 *
	 * @param zhongzUserOrderParam 用户信息
	 * @return 房屋集合
	 */
	@Override
	public Result<ZhongzHouse> selectZhongzUserHouseList(ZhongzUserOrderParam zhongzUserOrderParam)
	{
		zhongzUserOrderParam.genMysqlPage();
		//从Redis获取用户信息，没有降级去数据库获取
		String openid = zhongzUserOrderParam.getOpenid();
		String sessionKey = zhongzUserOrderParam.getSessionKey();
		HashOperations<String, String, ZhongzUser> hashOperations =  redisTemplate.opsForHash();
		ZhongzUser user = hashOperations.get(userKey,openid);
		if(user == null) {
			user = zhongzUserMapper.selectZhongzUserByOpenIdAndSessionKey(openid,sessionKey);
		}
		List<ZhongzContract> contracts = zhongzContractMapper.selectZhongzContractByUser(user.getId(),null,null);
		Integer totalNum = contracts.size();
		if(totalNum == 0) {
			return new Result<>(zhongzUserOrderParam.getPageNum(),zhongzUserOrderParam.getPageSize(),0,new ArrayList<>());
		}
		contracts = zhongzContractMapper.selectZhongzContractByUser(user.getId(),zhongzUserOrderParam.getLimitStart(),zhongzUserOrderParam.getLimitNum());
		if(contracts.size() == 0) {
			return new Result<>(zhongzUserOrderParam.getPageNum(),zhongzUserOrderParam.getPageSize(),totalNum,new ArrayList<>());
		}
		List<String> houseIds = new ArrayList<>();
		for(ZhongzContract contract : contracts) {
			houseIds.add(contract.getHouseId());
		}
		List<ZhongzHouse> houses = zhongzHouseMapper.selectZhongzHouseByIds(houseIds);
		return new Result<>(zhongzUserOrderParam.getPageNum(),zhongzUserOrderParam.getPageSize(),totalNum,houses);
	}

	/**
	 * 客户端首页可租房源列表
	 *
	 * @param zhongzHouseParam 房屋信息
	 * @return 房屋集合
	 */
	@Override
	public Result<ZhongzHouse> selectZhongzHouseRentList(ZhongzHouseParam zhongzHouseParam)
	{
		List<String> houseIds = new ArrayList<>();
		//所有前端显示未租整租房子id
		List<String> soloHouseIds = zhongzHouseMapper.selectZhongzHouseSoloRentIds();
		if(soloHouseIds != null && soloHouseIds.size() > 0) {
			houseIds.addAll(soloHouseIds);
		}
		//所有前端显示有未租房间的合租房id
		List<String> jointHouseIds = zhongzRoomMapper.selectZhongzRoomList1();
		if(jointHouseIds != null && jointHouseIds.size() > 0) {
			houseIds.addAll(jointHouseIds);
		}
		if(houseIds != null && houseIds.size() > 0) {
			//查询条件转换为id集合进行sql查询
			zhongzHouseParam.setHouseIds(houseIds);
			//查询指定热度标签集合对应的houseIds（中间表联合查询）,与之做交集（未租状态且含指定热度标签的）
			List<String> tagIds = zhongzHouseParam.getTagIds();
			if(tagIds != null && tagIds.size() > 0) {
				List<String> tagedHouseIds = zhongzHouseMapper.selectZhongzHouseTagedIds(tagIds);
				if(tagedHouseIds != null && tagedHouseIds.size() > 0) {
					houseIds.retainAll(tagedHouseIds);
				}
			}
			//指定活动的houseIds,做交集
			String eventId = zhongzHouseParam.getEventId();
			if(StringUtils.isNotBlank(eventId)) {
				List<String> eventedHouseIds = zhongzHouseMapper.selectZhongzHouseEventedIds(eventId);
				if(eventedHouseIds != null && eventedHouseIds.size() > 0) {
					houseIds.retainAll(eventedHouseIds);
				}
			}
			//有序集合，通过数据库sql已实现热度、更新时间倒序
			List<ZhongzHouse> houses = zhongzHouseMapper.selectZhongzHouseRentList(zhongzHouseParam);
			if(houses.size() > 0) {
				//小区信息
				List<String> estateIds = new ArrayList<>();
				for(ZhongzHouse house : houses) {
					estateIds.add(house.getEstateId());
				}
				List<ZhongzEstate> estates = zhongzEstateMapper.selectZhongzEstateList1(estateIds.toArray(new String[estateIds.size()]));
				Map<String,ZhongzEstate> estateMap = new HashMap<>();
				for(ZhongzEstate estate : estates) {
					estateMap.put(estate.getId(),estate);
				}
				for(ZhongzHouse house : houses) {
					house.setEstate(estateMap.get(house.getEstateId()));
				}
				//过滤条件：按关键字或历史标签模糊搜索地名或小区名
				String keyWord = zhongzHouseParam.getKeyWord();
				//关键字
				if(StringUtils.isNotBlank(keyWord)) {
					List<ZhongzHouse> searchHouses = new ArrayList<>();
					//houses是热度、更新时间倒序，遍历、插入另一个有序集合仍然是热度、更新时间倒序，不需要应用层排序
					for(ZhongzHouse house : houses) {
						if(StringUtils.isNotBlank(house.getRegion()) && house.getRegion().indexOf(keyWord) != -1) {
							searchHouses.add(house);
						}//不重复添加
						else if(house.getEstate() != null && StringUtils.isNotBlank(house.getEstate().getName())
								&& house.getEstate().getName().indexOf(keyWord) != -1) {
							searchHouses.add(house);
						}
					}
					return PageUtils.page(zhongzHouseParam.getPageNum(),zhongzHouseParam.getPageSize(),searchHouses);
				}
			}
			return PageUtils.page(zhongzHouseParam.getPageNum(),zhongzHouseParam.getPageSize(),houses);
		}
		return new Result<>(zhongzHouseParam.getPageNum(),zhongzHouseParam.getPageSize(),0,new ArrayList<>());
	}

    /**
     * 新增房屋
     * 
     * @param zhongzHouse 房屋信息
     * @return 结果
     */
	@Override
	public int insertZhongzHouse(ZhongzHouse zhongzHouse)
	{
		zhongzHouse.preInsert();
		return zhongzHouseMapper.insertZhongzHouse(zhongzHouse);
	}
	
	/**
     * 修改房屋
     * 
     * @param zhongzHouse 房屋信息
     * @return 结果
     */
	@Override
	public int updateZhongzHouse(ZhongzHouse zhongzHouse)
	{
		zhongzHouse.preUpdate();
		return zhongzHouseMapper.updateZhongzHouse(zhongzHouse);
	}

	/**
     * 删除房屋对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZhongzHouseByIds(String ids)
	{
		return zhongzHouseMapper.deleteZhongzHouseByIds1(Convert.toStrArray(ids));
	}
	
}
