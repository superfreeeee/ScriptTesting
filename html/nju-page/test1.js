var header1Block = Vue.component("header1-block", {
    props: ['prop'],
    template:
    '<div :id="prop.Id.divId">\
        <ul class="header1-ul" :id="prop.Id.ulId">\
            <li class="header1-li" v-for="item in prop.messages">\
                <a class="header1-link" href="">{{ item }}</a>\
            </li>\
        </ul>\
    </div>\
    '
})
var header1 = Vue.component('header1', {
    components: {
        "header1-block": header1Block
    },
    props: ['prop'],
    template:
    '<div class="header" id="header1">\
        <div id="header1-inner">\
            <header1-block :prop="prop_left"></header1-block>\
            <header1-block :prop="prop_right"></header1-block>\
        </div>\
    </div>',
    data() {
        var propLeftMessages = ["學生", "教職工", "考生", "校友", "訪客"];
        var propRightMessages = ["信息公開", "學生郵箱", "教師郵箱", "捐贈", "OA", "English"];
        var propLeftId = {divId: "header1-left", ulId: "header1-ul-l"};
        var propRightId = {divId: "header1-right", ulId: "header1-ul-r"};
        return {
            prop_left: {
                messages: propLeftMessages,
                Id: propLeftId
            },
            prop_right:{
                messages: propRightMessages,
                Id: propRightId
            }
        }
    },
    
})
new Vue({
    el: "#main-board",
    data() {
        return {
            
        }
    },
    methods: {
        
    },
    
    // components: {
    //     'header1': header1
    // }
})
