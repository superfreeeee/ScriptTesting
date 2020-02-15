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
new Vue({
    el: "#header1-inner",
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
var header3Banner = Vue.component('header3-banner', {
    props:['prop'],
    template:
    '<div id="header3-banner">\
        <div id="header3-banner-inner">\
            <ul id="header3-banner-ul" @click="bannerToggle">\
                <li class="header3-banner-li header3-link" v-for="item in prop">\
                    <span class="header3-text">{{ item }}</span>\
                    <img src="img/listbottom.png" alt="" id="listbottom">\
                </li>\
            </ul>\
        </div>\
    </div>',
    methods: {
        bannerToggle: function(){
            if(list_opened){
                document.getElementById("header3-list").style.height = 0+'px';
            }else{
                document.getElementById("header3-list").style.height = 240+'px';                
            }
            list_opened = !list_opened;
            // console.log("111");
            // var target = document.getElementById("header3-list");
            // var list_height = 0;
            // target.style.height = list_height + "px";
            // set_id = setInterval(function(){
            //     if(list_height > 290 || list_height < 0 ){
            //         clearInterval(set_id);
            //     }
            //     if(list_height < 0){
            //         if(list_height<=50){
            //             list_height+=2.5;
            //         }else if(list_height<=150){
            //             list_height+=5;
            //         }else{
            //             list_height+=10;
            //         }
            //     }else{
            //         if(list_height>=240){
            //             list_height-=2.5;
            //         }else if(list_height>=140){
            //             list_height-=5;
            //         }else{
            //             list_height-=10;
            //         }
            //     }    
            //     // if(list_height > 0 && list_height < 50){
            //     //     if(!list_opened){
            //     //         box_top+=0.5;                        
            //     //     }else{
            //     //         box_top-=2;
            //     //     }
            //     //     box.style. = box_top+"px 0";    
            //     // }
            //     target.style.height = list_height + "px";
            // },10);
        }
    }
})
var list_opened = false;

var header3List = Vue.component('header3-list', {
    
})
new Vue({
    el: "#header3-inner",
    data() {
        var bannerMessage = ["南大概況", "院系部門", "招生就業", "人才培養", "科學研究", "合作交流", "文化生活", "校園服務"];
        return {
            messages: bannerMessage,
            innerItems:[
                {blocks: [
                    "南大簡介",
                    "現任領導",
                    "歷任領導",
                    "南大校史",
                    "統計資料",
                    "南大標誌"
                ]},
                {blocks: [
                    "黨群組織",
                    "行政部門",
                    "院系設置",
                    "直屬單位"
                ]},
                {blocks: [
                    "招生",
                    "獎助學",
                    "就業創業"
                ]},
                {blocks: [
                    "師資隊伍",
                    "本科生",
                    "研究生",
                    "留學生",
                    "成人教育",
                    "遠程教育",
                    "三三制教學"
                ]},
                {blocks: [
                    "科研動態",
                    "科研機構",
                    "成果查詢",
                    "學術期刊"
                ]},
                {blocks: [
                    "國際合作",
                    "合作辦學",
                    "學生交流",
                    "成果轉化"
                ]},
                {blocks: [
                    "南大青年",
                    "工會",
                    "小百合BBS",
                    "微媒體"
                ]},
                {blocks: [
                    "電話黃頁",
                    "南大校曆",
                    "鼓樓服務大廳",
                    "圖書館",
                    "心理諮詢",
                    "後勤服務",
                    "網絡服務",
                    "媒體採訪",
                    "在線支付"
                ]},
            ],
        }
    },
    methods: {
        bannerToggle: function(){
            var target = document.getElementById("header3-list");
            set_id = setInterval(function(){
                if(list_height > 290 || list_height < 0){
                    clearInterval(set_id);
                }
                if(list_height < 0){
                    if(list_height<=50){
                        list_height+=2.5;
                    }else if(list_height<=150){
                        list_height+=5;
                    }else{
                        list_height+=10;
                    }
                }else{
                    if(list_height>=240){
                        list_height-=2.5;
                    }else if(list_height>=140){
                        list_height-=5;
                    }else{
                        list_height-=10;
                    }
                }    
                // if(list_height > 0 && list_height < 50){
                //     if(!list_opened){
                //         box_top+=0.5;                        
                //     }else{
                //         box_top-=2;
                //     }
                //     box.style. = box_top+"px 0";    
                // }
                target.style.height = list_height + "px";
            },10);
        }
    }
})


new Vue({
    el: "#container-m-right-in",
    data() {
        return {
            items:[
                {message: "電子郵箱" ,image: "img/container-m-right1.png"},
                {message: "辦公系統" ,image: "img/container-m-right2.png"},
                {message: "新聞網" ,image: "img/container-m-right3.png"},
                {message: "小百合BBS" ,image: "img/container-m-right4.png"},
                {message: "校友總會" ,image: "img/container-m-right5.png"},
                {message: "基金會" ,image: "img/container-m-right6.png"}
            ]
        }
    }
})
new Vue({
    el: "#container-m-left-ul",
    data() {
        return{
            items:[
                {src: "img/container-m-left1.png"},
                {src: "img/container-m-left2.png"},
                {src: "img/container-m-left3.png"},
                {src: "img/container-m-left4.png"},
            ]
        }
    }
})
new Vue({
    el: ".container-bottom-left-ul",
    data() {
        return{
            items:[
                {message: "PNAS論文報道潘丙才教授課題組在納米水處理技術及原理方面的研究新進展", src: "img/research1.png"},
                {message: "《自然》刊登南京大學戈惠明、譚仁祥和梁勇團隊研究成果自然界中首例催化[6+4]環...", src: "img/research2.png"},
                {message: "張利劍教授課題組在Phys. Rev. Lett.發表經典/量子系統互文性研究成果", src: "img/research3.png"},
                {message: "李承輝、左景林等在高強度自修復材料方面取得新進展", src: "img/research4.png"},
            ]
        }
    }
})
new Vue({
    el: ".container-top-right-ul",
    data() {
        return{
            items:[
                {day: "15", month: "2019-03", message: "校領導鼓樓校區值班表（3月18日--3月22日）"},
                {day: "08", month: "2019-03", message: "校領導鼓樓校區值班表（3月11日--3月15日）"},
                {day: "03", month: "2019-03", message: "校領導鼓樓校區值班表（3月4日--3月8日）"},
                {day: "06", month: "2019-01", message: "黨委辦公室 校長辦公室關於2019年寒假工作的通知"},
            ]
        }
    }
})
new Vue({
    el: "#container-top-left-bottom",
    data() {
        return{
            items:[
                {   title: "我校周志華教授獲IEEE計算機學會Edward J. McCluskey技術成就獎", 
                    date: "2019-03-17", 
                    content: "IEEE計算機學會近日宣佈，南京大學計算機科學與技術系主任、人工智能學院院長周志華教授被授予IEEE計算機學會2019年度Edward J. McCluskey Technical Achievement Award (https://www.computer.org/press-room/2019-..."
                },
                {   title: "我校舉行”建功立業新時代“輔導員素質能力比賽", 
                    date: "2019-03-17", 
                    content: "3月15日，我校舉辦”建功立業新時代“輔導員素質能力比賽決賽，校黨委副書記薛海林，校黨委常委、組織部部長郭隨平，相關部門負責同志出席比賽並擔任評委。本次輔導員素質能力比賽分為兩個階段。第一階段為筆試，全..."
                },
                {   title: "推進名城名校深度融合發展 南京大學蘇州校區落戶蘇州高新區", 
                    date: "2019-03-16", 
                    content: "為深入實施名城名校融合發展戰略，3月16日，南京大學與蘇州市人民政府在寧簽署全面戰略合作暨南京大學蘇州校區建設協議，雙方將在促進本科教育、研究生培養、國際化辦學、產學研協同創新等方面加強戰略合作，加快推..."
                },
                {   title: "我校召開2019年本科招生工作推進會", 
                    date: "2019-03-16", 
                    content: "為學習貫徹中共南京大學第十四屆委員會第五次全體（擴大）會議暨新學期工作會精神，推進落實我校2019年本科招生工作“一增一提一突破”的工作任務，3月15日，我校2019年本科招生工作推進會在行政北樓128會議室召開。..."
                }
            ]
        }
    }
})
var foot = Vue.component('foot', {
    template:
    '<div class="header" id="foot">\
        <div id="foot-inner">\
            <foot-address :prop="address"></foot-address>\
            <div id="foot-logo">\
                <img src="img/foot-logo.png" alt="" id="foot-logo">\
            </div>\
            <foot-share :prop="src"></foot-share>\
        </div>\
    </div>'
})
var footShare = Vue.component('foot-share', {
    props:['prop'],
    template:
    '<div id="foot-share">\
        <ul id="foot-share-ul">\
            <li id="foot-share-li" v-for="item in prop">\
                <a href="" class="share">\
                    <img :src="item" alt="" class="foot-share-p">\
                </a>\
            </li>\
        </ul>\
    </div>\
    '
})
var footAddress = Vue.component('foot-address', {
    props: ['prop'],
    template:
    '<div id="foot-address">\
        <div id="foot-address-board">\
            <ul id="foot-address-ul">\
                <li class="foot-address-li" v-for="item in prop">\
                    <p class="address-text">\
                        <span class="address-title">{{ item.title }}</span>\
                        <template v-for="line in item.content">\
                            <br/>{{ line }}\
                        </template>\
                    </p>\
                </li>\
            </ul>\
        </div>\
    </div>\
    '
})
// new vue({
//     el:'#main-board',
//     data() {
//         return {
            
//         }
//     },
//     component:{
        
//     }
// })
var footInner = new Vue({
    el: "#foot-inner",
    data() {
        var address1 = [
            "南京市栖霞區仙林大道163號",
            "(86)-25-89683186",
            "(86)-25-83302728（fax)",
            "210023"
        ]
        "南京市栖霞區仙林大道163號"+
        "(86)-25-89683186"+
        "(86)-25-83302728（fax)"+
        "210023";

        var address2 = [
            "南京市栖霞區仙林大道163號",
            "(86)-25-89683186",
            "(86)-25-83302728（fax)",
            "210023"
        ]
        return{
            address:[
                {title: "仙林校區", content: address1},
                {title: "鼓樓校區", content: address2}
            ],
            src:[
                "img/foot-share-p1.png",
                "img/foot-share-p2.png",
                "img/foot-share-p3.png"
            ]
        }   
    }
})
new Vue({
    el: "",
    data() {
        return{
            items:[
                {},
            ]
        }
    }
})