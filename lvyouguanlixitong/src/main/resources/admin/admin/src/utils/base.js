const base = {
    get() {
        return {
            url : "http://localhost:8080/lvyouguanlixitong/",
            name: "lvyouguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/lvyouguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "智慧旅游管理平台"
        } 
    }
}
export default base
