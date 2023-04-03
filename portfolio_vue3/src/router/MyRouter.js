import { createRouter, createWebHashHistory } from "vue-router";

const routes = [
    {
        path : '/',
        name : 'Home',
        component : () => import('../App.vue')
    },
    {
        path : '/menu/:menuName',
        name : 'menuModal',
        component : () => import('../components/modal/basic_modal.vue')
    }
]

const router = createRouter({
    routes,
    history : createWebHashHistory(process.env.BASE_URL)
})

export default router