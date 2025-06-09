import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import adminexam from '@/views/modules/shijuanliebiao/exam'
    import news from '@/views/modules/news/list'
    import laoshidayi from '@/views/modules/laoshidayi/list'
    import zhongqibaogao from '@/views/modules/zhongqibaogao/list'
    import xueshengtiti from '@/views/modules/xueshengtiti/list'
    import lunbotuguanli from '@/views/modules/lunbotuguanli/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import jiaoshi from '@/views/modules/jiaoshi/list'
    import biyelunwen from '@/views/modules/biyelunwen/list'
    import storeup from '@/views/modules/storeup/list'
    import zaixianxuanti from '@/views/modules/zaixianxuanti/list'
    import wenjianmoban from '@/views/modules/wenjianmoban/list'
    import lunwenjindu from '@/views/modules/lunwenjindu/list'
    import kaitibaogao from '@/views/modules/kaitibaogao/list'
    import xueshengtiwen from '@/views/modules/xueshengtiwen/list'
    import lunwenchazhong from '@/views/modules/lunwenchazhong/list'
    import luntanguanli from '@/views/modules/luntanguanli/list'

//2.配置路由   注意：名字
const routes = [
    {
        path: '/index', name:'index', component: Index, children: [{
            // 这里不设置值，是把main作为默认页面
            path: '/',
            name: 'home',
            component: Home
        },{
            path: '/updatePassword',
            name: 'updatePassword',
            component: UpdatePassword
        } ,{
            path: '/pay',
            name: 'pay',
            component: pay
        } ,{
            path: '/center',
            name: 'center',
            component: center
        } 
                    ,{
                path: '/news',
                name: 'news',
                component: news
            } 
                    ,{
                path: '/laoshidayi',
                name: 'laoshidayi',
                component: laoshidayi
            } 
                    ,{
                path: '/zhongqibaogao',
                name: 'zhongqibaogao',
                component: zhongqibaogao
            } 
                    ,{
                path: '/xueshengtiti',
                name: 'xueshengtiti',
                component: xueshengtiti
            } 
                    ,{
                path: '/lunbotuguanli',
                name: 'lunbotuguanli',
                component: lunbotuguanli
            } 
                    ,{
                path: '/xuesheng',
                name: 'xuesheng',
                component: xuesheng
            } 
                    ,{
                path: '/jiaoshi',
                name: 'jiaoshi',
                component: jiaoshi
            } 
                    ,{
                path: '/biyelunwen',
                name: 'biyelunwen',
                component: biyelunwen
            } 
                    ,{
                path: '/storeup',
                name: 'storeup',
                component: storeup
            } 
                    ,{
                path: '/zaixianxuanti',
                name: 'zaixianxuanti',
                component: zaixianxuanti
            } 
                    ,{
                path: '/wenjianmoban',
                name: 'wenjianmoban',
                component: wenjianmoban
            } 
                    ,{
                path: '/lunwenjindu',
                name: 'lunwenjindu',
                component: lunwenjindu
            } 
                    ,{
                path: '/kaitibaogao',
                name: 'kaitibaogao',
                component: kaitibaogao
            } 
                    ,{
                path: '/xueshengtiwen',
                name: 'xueshengtiwen',
                component: xueshengtiwen
            } 
                    ,{
                path: '/lunwenchazhong',
                name: 'lunwenchazhong',
                component: lunwenchazhong
            } 
                    ,{
                path: '/luntanguanli',
                name: 'luntanguanli',
                component: luntanguanli
            } 
                ]
    },
    { path: '/adminexam', name: 'adminexam', component: adminexam },
    { path: '/login', name:'login', component: Login },
    { path: '/register', name:'register', component: register },
    { path: '/', redirect: '/index/' },      /*默认跳转路由*/
    { path: '*', component: NotFound }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
    mode: 'hash',   /*hash模式改为history*/
    routes // （缩写）相当于 routes: routes
})

export default router;

