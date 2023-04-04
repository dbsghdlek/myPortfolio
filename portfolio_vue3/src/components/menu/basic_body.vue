<template>
    <div class="container">
        <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0"></h2>
        <!-- Icon Divider-->
        <div class="divider-custom">
            <div class="divider-custom-line"></div>
            <div class="divider-custom-icon"><i class="fas fa-star">{{ menuName.toUpperCase() }}</i></div>
            <div class="divider-custom-line"></div>
        </div>
    </div>
</template>
<script>

export default {
    data() {
        return {
            menuName : this.$route.params.menuName
        }
    },
    methods: {
    },
    components: {
        //MusicBody,
        //HobbyBody
    }
}
</script>

<style></style>