<template>
    <div class="container page-section">
        <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">
            {{ menuName.toUpperCase() }}
        </h2>
        <!-- Icon Divider-->
        <div class="divider-custom">
            <div class="divider-custom-line"></div>
            <div class="divider-custom-icon"><i class="fas fa-star"/></div>
            <div class="divider-custom-line"></div>
        </div>
        <div v-if="menuName === 'music'">
            <music_body/>
        </div>
    </div>
</template>
<script>
import music_body from './menu_body/music/myMusic.vue' 
export default {
    data() {
        return {
            menuName : this.$route.params.menuName
        }
    },
    methods: {
    },
    components: {
        music_body
        //HobbyBody
    }
}
</script >

<style ></style>