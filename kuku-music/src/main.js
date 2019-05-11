import Vue from 'vue'
import App from './App'
import router from './router'
//  引入iView
import iView from 'iview';
import 'iview/dist/styles/iview.css';
Vue.use(iView);

//  引入Vuex
import store from './store'

//  引入animate.css
import '@/assets/styles/animate/animate.css'
//  引入Moment
import Moment from 'moment'
//  引入APlayer音乐播放器
import APlayer from '@moefe/vue-aplayer'
//  引入axios的API
import http from './http'
//  引入ProgressBar
import VueProgressBar from 'vue-progressbar'
//  引入Iconfont
import '@/assets/styles/iconfont/iconfont.css'


const options = {
  color: '#ff7d83',
  failedColor: '#874b4b',
  thickness: '2px',
  transition: {
    speed: '0.2s',
    opacity: '0.6s',
    termination: 300
  },
  autoRevert: true,
  location: 'top',
  inverse: false
}

Vue.use(VueProgressBar, options)
Vue.prototype.$http = http; // 将api挂载到vue的原型上

//全局过滤器
Vue.filter('dateFmt', (input, formatString = "YYYY-MM-DD") => {
  let nowTime = Moment()
  let inputTime = Moment(input)
  if (nowTime.subtract(15, 'days') > inputTime) {
    return inputTime.format(formatString);
  } else
    return inputTime.fromNow()
})

Vue.filter('timeFmt', (input) => {
  let inputTime = Moment.duration(input)
  return inputTime.hours() === 0 ?
    (inputTime.minutes() === 0 ? (inputTime.seconds() + '秒') : (inputTime.minutes() + '分' + inputTime.seconds() + '秒')) :
    (inputTime.hours() + '时' + inputTime.minutes() + '分' + inputTime.seconds() + '秒');
})

Vue.use(APlayer, {
  productionTip: false,
});

Vue.prototype.$moment = Moment

Vue.config.productionTip = false


router.beforeEach((to, from, next) => {
  iView.LoadingBar.start();
  next();
});

router.afterEach(route => {
  iView.LoadingBar.finish();
});

new Vue({
  el: '#app',
  router,
  store,
  components: {App},
  template: '<App/>'
})
