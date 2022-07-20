import Vue from 'vue'
import VueRouter from 'vue-router'
import AbsenceView from "@/views/AbsenceView";
import LoginView from "@/views/LoginView";
import Main from "@/views/Main";

Vue.use(VueRouter)

const routes = [
  {
    path:'/',
    name:'LoginView',
    component: LoginView
  },
  {
    path:'/absences',
    name:'AbsenceView',
    component: AbsenceView
  },
  {
    path:'/main',
    name:'Main',
    component: Main
  }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
