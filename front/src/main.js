import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';
import VueRouter from 'vue-router'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'
import * as charts from 'echarts';
import router from './router'
Vue.use(ElementUI);
Vue.use(VueRouter);
Vue.prototype.$charts=charts
new Vue({
  el: '#app',
  router,
  beforeCreate() {
    Vue.prototype.$bus = this //安装全局事件总线，$bus 就是当前应用的vm
  },
  render: h => h(App)
});