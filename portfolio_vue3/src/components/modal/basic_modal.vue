<template>
    <div class="portfolio-modal modal fade" :id="`portfolioModal1`" tabindex="-1" aria-labelledby="portfolioModal6"
        aria-hidden="true">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header border-0">
                    <button @click="closeModal" class="btn-close" type="button" data-bs-dismiss="modal"
                        aria-label="Close"></button>
                </div>
                <div class="modal-body text-center pb-5">
                    <MusicBody v-if="menuName == 'music'" />
                    <HobbyBody v-if="menuName == 'hobby'" />
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import MusicBody from './modal_body/music/myMusic.vue'
import HobbyBody from './modal_body/myHobby.vue'

export default {
    data(){
        return{
            menuInfo : {}
        } 
    },
    methods: {
        closeModal() {
            this.$emit('basicModalClose');
        }
    },
    components: {
        MusicBody,
        HobbyBody
    }
}
</script>

<style>
</style>