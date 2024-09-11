import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import address from '@/views/modules/address/list'
    import cart from '@/views/modules/cart/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import jingdian from '@/views/modules/jingdian/list'
    import jingdianCollection from '@/views/modules/jingdianCollection/list'
    import jingdianCommentback from '@/views/modules/jingdianCommentback/list'
    import jingdianOrder from '@/views/modules/jingdianOrder/list'
    import jiudian from '@/views/modules/jiudian/list'
    import jiudianCollection from '@/views/modules/jiudianCollection/list'
    import jiudianCommentback from '@/views/modules/jiudianCommentback/list'
    import jiudianOrder from '@/views/modules/jiudianOrder/list'
    import liuyan from '@/views/modules/liuyan/list'
    import luxian from '@/views/modules/luxian/list'
    import luxianCollection from '@/views/modules/luxianCollection/list'
    import luxianLiuyan from '@/views/modules/luxianLiuyan/list'
    import shangpin from '@/views/modules/shangpin/list'
    import shangpinCollection from '@/views/modules/shangpinCollection/list'
    import shangpinCommentback from '@/views/modules/shangpinCommentback/list'
    import shangpinOrder from '@/views/modules/shangpinOrder/list'
    import yonghu from '@/views/modules/yonghu/list'
    import config from '@/views/modules/config/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryIsdefault from '@/views/modules/dictionaryIsdefault/list'
    import dictionaryJingdian from '@/views/modules/dictionaryJingdian/list'
    import dictionaryJingdianCollection from '@/views/modules/dictionaryJingdianCollection/list'
    import dictionaryJingdianOrder from '@/views/modules/dictionaryJingdianOrder/list'
    import dictionaryJiudian from '@/views/modules/dictionaryJiudian/list'
    import dictionaryJiudianCollection from '@/views/modules/dictionaryJiudianCollection/list'
    import dictionaryJiudianOrder from '@/views/modules/dictionaryJiudianOrder/list'
    import dictionaryLuxianCollection from '@/views/modules/dictionaryLuxianCollection/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangpin from '@/views/modules/dictionaryShangpin/list'
    import dictionaryShangpinCollection from '@/views/modules/dictionaryShangpinCollection/list'
    import dictionaryShangpinOrder from '@/views/modules/dictionaryShangpinOrder/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryIsdefault',
        name: '是否默认地址',
        component: dictionaryIsdefault
    }
    ,{
        path: '/dictionaryJingdian',
        name: '景点类型',
        component: dictionaryJingdian
    }
    ,{
        path: '/dictionaryJingdianCollection',
        name: '收藏表类型',
        component: dictionaryJingdianCollection
    }
    ,{
        path: '/dictionaryJingdianOrder',
        name: '订单类型',
        component: dictionaryJingdianOrder
    }
    ,{
        path: '/dictionaryJiudian',
        name: '酒店类型',
        component: dictionaryJiudian
    }
    ,{
        path: '/dictionaryJiudianCollection',
        name: '收藏表类型',
        component: dictionaryJiudianCollection
    }
    ,{
        path: '/dictionaryJiudianOrder',
        name: '订单类型',
        component: dictionaryJiudianOrder
    }
    ,{
        path: '/dictionaryLuxianCollection',
        name: '收藏表类型',
        component: dictionaryLuxianCollection
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangpin',
        name: '美食类型',
        component: dictionaryShangpin
    }
    ,{
        path: '/dictionaryShangpinCollection',
        name: '收藏表类型',
        component: dictionaryShangpinCollection
    }
    ,{
        path: '/dictionaryShangpinOrder',
        name: '订单类型',
        component: dictionaryShangpinOrder
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/address',
        name: '收货地址',
        component: address
      }
    ,{
        path: '/cart',
        name: '购物车',
        component: cart
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/jingdian',
        name: '景点',
        component: jingdian
      }
    ,{
        path: '/jingdianCollection',
        name: '景点收藏',
        component: jingdianCollection
      }
    ,{
        path: '/jingdianCommentback',
        name: '景点评价',
        component: jingdianCommentback
      }
    ,{
        path: '/jingdianOrder',
        name: '景点订单',
        component: jingdianOrder
      }
    ,{
        path: '/jiudian',
        name: '酒店',
        component: jiudian
      }
    ,{
        path: '/jiudianCollection',
        name: '酒店收藏',
        component: jiudianCollection
      }
    ,{
        path: '/jiudianCommentback',
        name: '酒店评价',
        component: jiudianCommentback
      }
    ,{
        path: '/jiudianOrder',
        name: '酒店订单',
        component: jiudianOrder
      }
    ,{
        path: '/liuyan',
        name: '留言板',
        component: liuyan
      }
    ,{
        path: '/luxian',
        name: '路线推荐',
        component: luxian
      }
    ,{
        path: '/luxianCollection',
        name: '路线推荐收藏',
        component: luxianCollection
      }
    ,{
        path: '/luxianLiuyan',
        name: '路线推荐评论',
        component: luxianLiuyan
      }
    ,{
        path: '/shangpin',
        name: '美食',
        component: shangpin
      }
    ,{
        path: '/shangpinCollection',
        name: '美食收藏',
        component: shangpinCollection
      }
    ,{
        path: '/shangpinCommentback',
        name: '美食评价',
        component: shangpinCommentback
      }
    ,{
        path: '/shangpinOrder',
        name: '美食订单',
        component: shangpinOrder
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
