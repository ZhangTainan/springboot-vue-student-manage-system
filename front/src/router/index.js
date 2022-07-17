import VueRouter from 'vue-router'
// 引入组件
// import Students from '../components/Students'
import Table from '../components/Table'
import User from '../components/User'
import Login from '../components/Login'
import Register from '../components/Register'
import Logout from '../components/Logout'
import Analysis from '../components/Analysis'
// import Logout from '../components/Logout'
// 创建一个路由器 
// import axios from 'axios'
const router = new VueRouter({
    mode:"history",
    routes: [
       
        {
            path: "/user",
            component: User,
            name: "user",
            children: [
                {
                    path: "login",
                    component: Login,
                    name: "login",
                },
                {
                    path: "register",
                    component: Register,
                    name: "register",
                }
            ]
        },
        {
            path: "/students",
            component: Table,
            name: "students",
        },
        {
            path: "/logout",
            component: Logout,
            name: "logout",
        },
        {
            path: "/analysis",
            component: Analysis,
            name: "analysis",
        }
        // {
        //     path: "/logout",
        //     component: Logout,
        //     name: "logout"
        // }
    ]
})

export default router