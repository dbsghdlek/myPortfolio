<template>
    <section class="page-section portfolio" id="portfolio">
        <div class="container">
            <!-- Portfolio Section Heading-->
            <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Menu</h2>
            <!-- Icon Divider-->
            <div class="divider-custom">
                <div class="divider-custom-line"></div>
                <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                <div class="divider-custom-line"></div>
            </div>
            <!-- Portfolio Grid Items-->
            <div class="row justify-content-center">
                <div id="menu" v-for="(menu) in menuList" :key="menu.menuId" class="col-md-6 col-lg-4 mb-5">
                    <router-link :to="`/menu/${menu.menuName}`">
                        <div class="portfolio-item mx-auto">
                            <div
                                class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
                                <div class="portfolio-item-caption-content text-center text-white">
                                    <i class="fas fa-plus fa-3x"></i>
                                </div>
                            </div>
                            <img class="img-fluid" :src='`${menu.src}`' alt="image" />
                        </div>
                    </router-link>
                </div>
            </div>
        </div>
    </section>
</template>
<script>
import axios from 'axios'

export default {
    data() {
        return {
            menuList: [],
        }
    },
    methods: {
        bindingItem() {
            axios.get('/menu/list', {
                headers: {
                    Accept: 'application/json'
                }
            }).then(
                response => {
                    this.menuList = response.data.map(item => {
                        return {
                            ...item,
                            src: require('@/assets/img/portfolio/' + item.menuName + '.png')
                        }
                    });
                }
            ).catch(error => console.log(error))
        }
    },
    created() {
        this.bindingItem();
    }
}
</script>