import { createRouter, createWebHistory } from "vue-router";

const routes = [
    {
        path : '/',
        name : 'menuGrid',
        component : () => import('../views/main_menu.vue'),
    },
    {
        path: '/:menuName',
        name: 'menuPage',
        component : () => import('../views/menu/basic_body.vue')
    }
]

const router = createRouter({
    routes,
    history : createWebHistory(process.env.BASE_URL)
})

export default router