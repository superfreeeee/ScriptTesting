var mainContainer = {
    // props:{
    //     prop1: ['info'],
    //     prop2: ['errored'],
    //     prop3: ['loading']
    // },
    data() {
        return {
            info: null,
            failmsg: null,
            loading: true,
            errored: false,
            inputNumber: '',
            dataRequestSuccess: false
        }
    },
    template:
    '<div id="main-container" class="board">\
        <span class="small-title">快遞查詢</span>\
        <input type="text" class="search" v-model="inputNumber" placeholder="輸入單號..."/>\
        <span id="submit" class="search" @click="dataRequest">查詢</span>\
        <section v-if="errored">消息錯誤</section>\
        <section v-else>\
            <div id="info-board">\
                <section v-if="dataRequestSuccess">\
                    <div class="info-msg info-title">\
                        <span>快遞單號：{{ info.mailNo }}</span>\
                    </div>\
                    <ul style="margin-left:20px;">\
                        <li v-for="item in info.data" class="info-msg">\
                            <div id="info-time" class="info-msg info-li">\
                                <span>{{ item.time }}</span>\
                            </div>\
                            <div id="info-content" class="info-msg">\
                                <span>{{ item.context }}</span>\
                            </div>\
                        </li>\
                    </ul>\
                </section>\
                <section v-else class="info-msg info-title">\
                    <span>{{ failmsg }}</span>\
                </section>\
            </div>\
        </section>\
    </div>',
    filters: {
        currencydecimal (value) {
            return value.toFixed(2)
        }
    },
    methods: {
        dataRequest() {
            if(this.inputNumber=='' || this.inputNumber==null){
                this.dataRequestSuccess = false;
                this.failmsg = "請輸入單號！";
                console.log("null input");
                return;
            }else if(this.inputNumber.length!=13 || isNaN(this.inputNumber)){
                this.dataRequestSuccess = false;
                this.failmsg = "單號不合法！";
                console.log("invalid input");
            }else{
                console.log("valid input");
                console.log("data request");
                var obj_this = this;
                axios
                .get('https://biz.trace.ickd.cn/auto/'+this.inputNumber)
                .then(response => {
                    obj_this.info = response.data;
                    console.log("data get");
                    console.log("單號："+this.inputNumber);
                    this.dataRequestSuccess = true;
                })
                .catch(error => {
                    obj_this.errored = true;
                    console.log(error)
                })
                .finally(() => {
                    obj_this.loading = false;
                    console.log(obj_this.info+' '+obj_this.loading+' '+obj_this.errored);
                })
            }
        },
    },
    mounted() {
        console.log('main-container built.')
    },
}
var mainBanner = {
    template:
    '<div id="main-banner">\
        <div  class="board" style="width:1200px">\
            <span style="width:1000px;margin 0 auto;">快遞查詢系統</span>\
        </div>\
    </div>',
    mounted() {
        console.log('main-banner built.')
    },
}
var mainBoard = {
    template:
    '<div>\
        <main-banner></main-banner>\
        <main-container></main-container>\
    </div>\
    ',
    components: {
        'main-container': mainContainer,
        'main-banner': mainBanner
    },
    mounted() {
        console.log('main-board built.')
    },
}
new Vue({
    el: '#main-board',
    components:{
        'main-board': mainBoard
    }
})
