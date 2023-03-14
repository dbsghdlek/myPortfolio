<template>
    <div>
        <basic_modal>
            <h2 slot="title"> Music </h2>
            <div slot="body">
                <img class="img-fluid rounded mb-5" src="@/assets/img/portfolio/cabin.png" alt="..." />
            </div>
        </basic_modal>
    </div>
</template>
<script>
import basic_modal from './basic_modal.vue'

export default{
    components:{
        basic_modal
    },
    methods: {
        closeModal() {
            this.$emit('musicModalClose');
        }
    }
}
</script>