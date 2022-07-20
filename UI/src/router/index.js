import Vue from 'vue'
import VueRouter from 'vue-router'
import AbsenceView from "@/views/AbsenceView";
import LoginView from "@/views/LoginView";
import NewAbsenceModal from "@/views/NewAbsenceModal";

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
    path:'/newAbsence',
    name:'NewAbsenceModal',
    component: NewAbsenceModal
  }
]

const router = new VueRouter({
  routes
})

export default router
