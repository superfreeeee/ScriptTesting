<template>
<div>
    <div id='main-board'>
        <h1>Price Index</h1>\
        <!-- <button @click="dataRequest">request</button> -->
        <section v-if="errored">Error</section>
        <section v-else>\
            <div v-if="loading">Loading...</div>
            <!-- <div v-else v-for="currency in info" :key=id> -->
                {{ info }}
                {{ currency.description }} : {{ currency.rate_float | currencydecimal}}
            <!-- </div> -->
        </section>
    </div>
</div>
</template>

<script>
export default {
    data() {
        return {
            id: 0,
            info: null,
            loading: true,
            errored: false
        }
    },
    filters: {
        currencydecimal (value) {
            return value.toFixed(2)
        }
    },
    mounted() {
            ()=>{
            console.log("data request");
            axios
                .get('https://api.coindesk.com/v1/bpi/currentprice.json')
                .then(response => {
                    // console.log(this.info)
                    this.info = response.data.bpi;
                    console.log("data get");
                    console.log(this.info);
                })
                .catch(error => {
                    console.log(this.error)
                    this.errored = true;
                })
                .finally(() => {
                    this.loading = false;
                    console.log(this.info+' '+this.loading+' '+this.errored);
                })
        }
    },
    
}
</script>

<style lang="">
#main-board
{
    width: 1160px;
    height: 500px;
    margin: 0 auto;
    background-color: blue;
}
</style>