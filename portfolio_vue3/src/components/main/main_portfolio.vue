<template>
    
</template>
<script>

export default {
    props : {
        main_item : {
            type : String
        }
    },
    data() {
        return{
            image1 : require(this.main_item)
        }
    }
}


</script>

<style></style>