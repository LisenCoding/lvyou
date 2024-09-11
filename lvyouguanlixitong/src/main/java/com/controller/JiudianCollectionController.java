
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 酒店收藏
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiudianCollection")
public class JiudianCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(JiudianCollectionController.class);

    private static final String TABLE_NAME = "jiudianCollection";

    @Autowired
    private JiudianCollectionService jiudianCollectionService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JingdianService jingdianService;//景点
    @Autowired
    private JingdianCollectionService jingdianCollectionService;//景点收藏
    @Autowired
    private JingdianCommentbackService jingdianCommentbackService;//景点评价
    @Autowired
    private JingdianOrderService jingdianOrderService;//景点订单
    @Autowired
    private JiudianService jiudianService;//酒店
    @Autowired
    private JiudianCommentbackService jiudianCommentbackService;//酒店评价
    @Autowired
    private JiudianOrderService jiudianOrderService;//酒店订单
    @Autowired
    private LiuyanService liuyanService;//留言板
    @Autowired
    private LuxianService luxianService;//路线推荐
    @Autowired
    private LuxianCollectionService luxianCollectionService;//路线推荐收藏
    @Autowired
    private LuxianLiuyanService luxianLiuyanService;//路线推荐评论
    @Autowired
    private ShangpinService shangpinService;//美食
    @Autowired
    private ShangpinCollectionService shangpinCollectionService;//美食收藏
    @Autowired
    private ShangpinCommentbackService shangpinCommentbackService;//美食评价
    @Autowired
    private ShangpinOrderService shangpinOrderService;//美食订单
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = jiudianCollectionService.queryPage(params);

        //字典表数据转换
        List<JiudianCollectionView> list =(List<JiudianCollectionView>)page.getList();
        for(JiudianCollectionView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiudianCollectionEntity jiudianCollection = jiudianCollectionService.selectById(id);
        if(jiudianCollection !=null){
            //entity转view
            JiudianCollectionView view = new JiudianCollectionView();
            BeanUtils.copyProperties( jiudianCollection , view );//把实体数据重构到view中
            //级联表 酒店
            //级联表
            JiudianEntity jiudian = jiudianService.selectById(jiudianCollection.getJiudianId());
            if(jiudian != null){
            BeanUtils.copyProperties( jiudian , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJiudianId(jiudian.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jiudianCollection.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiudianCollectionEntity jiudianCollection, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiudianCollection:{}",this.getClass().getName(),jiudianCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jiudianCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiudianCollectionEntity> queryWrapper = new EntityWrapper<JiudianCollectionEntity>()
            .eq("jiudian_id", jiudianCollection.getJiudianId())
            .eq("yonghu_id", jiudianCollection.getYonghuId())
            .eq("jiudian_collection_types", jiudianCollection.getJiudianCollectionTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiudianCollectionEntity jiudianCollectionEntity = jiudianCollectionService.selectOne(queryWrapper);
        if(jiudianCollectionEntity==null){
            jiudianCollection.setInsertTime(new Date());
            jiudianCollection.setCreateTime(new Date());
            jiudianCollectionService.insert(jiudianCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiudianCollectionEntity jiudianCollection, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiudianCollection:{}",this.getClass().getName(),jiudianCollection.toString());
        JiudianCollectionEntity oldJiudianCollectionEntity = jiudianCollectionService.selectById(jiudianCollection.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jiudianCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            jiudianCollectionService.updateById(jiudianCollection);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiudianCollectionEntity> oldJiudianCollectionList =jiudianCollectionService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jiudianCollectionService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<JiudianCollectionEntity> jiudianCollectionList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiudianCollectionEntity jiudianCollectionEntity = new JiudianCollectionEntity();
//                            jiudianCollectionEntity.setJiudianId(Integer.valueOf(data.get(0)));   //酒店 要改的
//                            jiudianCollectionEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jiudianCollectionEntity.setJiudianCollectionTypes(Integer.valueOf(data.get(0)));   //类型 要改的
//                            jiudianCollectionEntity.setInsertTime(date);//时间
//                            jiudianCollectionEntity.setCreateTime(date);//时间
                            jiudianCollectionList.add(jiudianCollectionEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jiudianCollectionService.insertBatch(jiudianCollectionList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jiudianCollectionService.queryPage(params);

        //字典表数据转换
        List<JiudianCollectionView> list =(List<JiudianCollectionView>)page.getList();
        for(JiudianCollectionView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiudianCollectionEntity jiudianCollection = jiudianCollectionService.selectById(id);
            if(jiudianCollection !=null){


                //entity转view
                JiudianCollectionView view = new JiudianCollectionView();
                BeanUtils.copyProperties( jiudianCollection , view );//把实体数据重构到view中

                //级联表
                    JiudianEntity jiudian = jiudianService.selectById(jiudianCollection.getJiudianId());
                if(jiudian != null){
                    BeanUtils.copyProperties( jiudian , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiudianId(jiudian.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jiudianCollection.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JiudianCollectionEntity jiudianCollection, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiudianCollection:{}",this.getClass().getName(),jiudianCollection.toString());
        Wrapper<JiudianCollectionEntity> queryWrapper = new EntityWrapper<JiudianCollectionEntity>()
            .eq("jiudian_id", jiudianCollection.getJiudianId())
            .eq("yonghu_id", jiudianCollection.getYonghuId())
            .eq("jiudian_collection_types", jiudianCollection.getJiudianCollectionTypes())
//            .notIn("jiudian_collection_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiudianCollectionEntity jiudianCollectionEntity = jiudianCollectionService.selectOne(queryWrapper);
        if(jiudianCollectionEntity==null){
            jiudianCollection.setInsertTime(new Date());
            jiudianCollection.setCreateTime(new Date());
        jiudianCollectionService.insert(jiudianCollection);

            return R.ok();
        }else {
            return R.error(511,"您已经收藏过了");
        }
    }

}

