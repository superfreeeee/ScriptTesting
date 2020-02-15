// Vue.component("banner", {
//     props: ['messages'],
//     template:
//     '\
//     <div id="banner-left" class="messages.class">\
//         <li v-for="item in messages.text">\
//             <span>{{ item }}</span>\
//         </li>\
//     </div>\
//     '
// })
// new Vue({
//     el: "#banner1",
//     data() {
//         return {
//             messages:{
//                 text: [
//                     "text1",
//                     "text2",
//                     "text3",
//                     "text4",
//                     "text5",
//                 ],
//                 class: "banner1"
//             }
//         }
//     },
// })
Vue.component("header1-block", {
    props:['prop'],
    template: 
    '<div :id="prop.divId">\
    </div>'
})
{/* <ul :class="prop.class.ulClass" :id="prop.id.ulId">\
    <li :class="prop.class.liClass" v-for="item in prop.messages">\
        <a :class="prop.class.aClass" href="">{{ item }}</a>\
    </li>\
</ul>\ */}
new Vue({
    el: "#banner-block",
    data() {
        return {
            prop_left:{
                divId: "header1-left",
                id: {
                    divId: "header1-left",
                    ulId: "header1-ul-l"
                },
                class:{
                    ulClass: "header1-ul",
                    liClass: "header1-li",
                    aClass: "header1-link"
                },
                messages:[
                    "學生",
                    "教職工",
                    "考生",
                    "校友",
                    "訪客"
                ]
            }
        }
    }
})