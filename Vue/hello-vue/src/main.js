import Vue from 'vue'
import App from './App'

// 扫描router
import router from './router'
// 导入element-ui 和需要的组件
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// Axios
import axios from 'axios';
import VueAxios from 'vue-axios'


Vue.config.productionTip = false

Vue.use(router)
Vue.use(ElementUI)
Vue.use(VueAxios, axios)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App) // elementUI
})
