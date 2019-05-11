import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/pages/home/Home'
import MusicSearch from '@/pages/music/MusicSearch'
import Music from '@/pages/music/Music'
import MusicList from '@/pages/music/MusicList'
import User from '@/pages/home/components/User'
import About from '@/pages/about/About'
//
Vue.use(VueRouter)
const router = new VueRouter({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
    },
    {
      path: '/musicSearch',
      name: 'MusicSearch',
      component: MusicSearch,
    },
    {
      path: '/music',
      name: 'Music',
      component: Music,
    },
    {
      path: '/musicList',
      name: 'MusicList',
      component: MusicList,
    },
    {
      path: '/user/:id',
      name: 'user',
      component: User,
    },
    {
      path: '/about',
      name: 'About',
      component: About,
    },
  ]
})


export default router
