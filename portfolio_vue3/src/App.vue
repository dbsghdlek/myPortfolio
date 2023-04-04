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
        <!-- Copyright Section-->
        <div class="copyright py-4 text-center text-white">
            <div class="container"><small>Copyright &copy; Your Website 2022</small></div>
        </div>        
    </body>
</template>             
<script>
import main_header from './components/main_header'
import main_nav from './components/main_nav'
import basic_footer from './components/basic_footer.vue'
import about_template from './components/my_about.vue'

export default {
    components: {
        main_header,
        main_nav,
        basic_footer,
        about_template
    },
    data() {
        return {
            
        }
    },
    methods: {
        
    },
    
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