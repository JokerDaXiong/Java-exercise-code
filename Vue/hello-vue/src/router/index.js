import Vue from 'vue'
import Router from 'vue-router'

import Main from '../views/Main'
import Login from '../views/Login'

import UserList from '../views/user/List'
import UserProfile from '../views/user/Profile'
import NotFound from '../views/NotFound'

Vue.use(Router)


export default new Router({
  model: 'history',
  routes:[
    {
      path: '/main/:name',
      component: Main,// 嵌套路由
      props: true,
      children: [
        // name: 必须在单引号内 props: true 解耦
        {path: '/user/profile/:id',name: 'UserProfile',component: UserProfile,props: true},
        {path: '/user/list',component: UserList}
      ]
    },
    {
      path: '/login',
      component: Login
    },{
      // 重定向
      path: '/goHome',
      redirect: '/main'
    },{
      // 404
      path: '*',
      component: NotFound
    }
  ]
});
