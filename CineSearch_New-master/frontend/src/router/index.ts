import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import Tabs from '../views/TabsPage.vue'


const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/tabs/HomePage'
  },
  {
    path: '/tabs/',
    component: Tabs,
    children: [
      {
        path: '',
        redirect: '/tabs/'
      },
      {
        path: 'HomePage',
        component: () => import('@/views/HomePage.vue')
      },
      {
        path: 'MovieSearch',
        component: () => import('@/views/MovieSearch.vue')
      },
      {
        path: 'SupportPage',
        component: () => import('@/views/SupportPage.vue')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
