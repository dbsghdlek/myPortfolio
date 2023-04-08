import { createRouter, createWebHistory } from "vue-router";

const routes = [
    {
        path : '/',
        name : 'menuGrid',
        component : () => import('../components/main/menu_grid.vue'),
    },
    {
        path: '/menu/:menuName',
        name: 'menuPage',
        component : () => import('../components/menu/basic_body.vue')
    }
]

const router = createRouter({
    routes,
    history : createWebHistory(process.env.BASE_URL)
})

export default router