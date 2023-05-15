<template>
    <body id="page-top">
        <!-- Navigation-->
        <main_nav />
        <main_header />
        <router-view />
        <!-- About Section-->
        <about_template />
        <!-- Footer-->
        <basic_footer />
        <music_bar v-if="musicBarExposed"/>
        <!-- Copyright Section-->
        <div class="copyright py-4 text-center text-white">
            <div class="container"><small>Copyright &copy; Your Website 2022</small></div>
        </div>    
        
    </body>
</template>             
<script>
import main_header from './components/main_header.vue'
import main_nav from './components/main_nav.vue'
import basic_footer from './components/basic_footer.vue'
import about_template from './components/my_about.vue'
import music_bar from './components/music_bar.vue'
import { mapState } from 'vuex'


export default {
    components: {
        main_header,
        main_nav,
        basic_footer,
        about_template,
        music_bar
    },
    data() {
        return {
            
        }
    },
    methods: {
        
    },
    computed:{
        ...mapState(['musicBarExposed'])
    }
    
}

</script>
<style scoped>
@import "./css/styles.css";

/* 모달 페이드 */
.fade-enter-from {
    transform: translateY(-150px);
}

.fade-enter-active {
    transition: all 0.3s;
}

.fade-enter-to {
    transform: translateY(0px);
}

.fade-leave-from {
    opacity: 1;
}

.fade-leave-active {
    transition: all 0.4s;
}

.fade-leave-to {
    opacity: 0;
}


</style>