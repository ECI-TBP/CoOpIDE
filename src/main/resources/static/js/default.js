var editor = ace.edit("editor");
editor.setTheme("ace/theme/dracula");
editor.session.setMode("ace/mode/java");

function textCapture() {
    var text = editor.getValue();
    console.log(editor.getValue());
    stompClient.send("/topic/file", {}, text);
    //axios.put('file', text).then(function (response){
        
    //}).catch(function (error) {
    //    alert("error:"+error);
    //});
}



var stompClient = null; 

var connectAndSubscribe = function () {
        console.info('Connecting to WS...');
        var socket = new SockJS('/stompendpoint');
        stompClient = Stomp.over(socket);
        
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/file', function (eventbody) {
                
                
            });
        });

};