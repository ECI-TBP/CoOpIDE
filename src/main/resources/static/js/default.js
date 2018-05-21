var editor = ace.edit("editor");
editor.setTheme("ace/theme/dracula");
editor.session.setMode("ace/mode/javascript");
editor.on('change', function() { textCapture() });

function textCapture() {
    var text = editor.getValue();
    console.log(editor.getValue());
    stompClient.send("/topic/file/default", {}, JSON.stringify(text));
    
    axios.post('/file/default', ("default",text)).then(function (response){
        
    }).catch(function (error) {
        alert("error:"+error);
    });
}



var stompClient = null; 

var connectAndSubscribe = function () {
        console.info('Connecting to WS...');
        var socket = new SockJS('/stompendpoint');
        stompClient = Stomp.over(socket);
        
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/file/default', function (eventbody) {
                
            });
        });
        
        
        axios.get('/file/default').then(function (response){
        editor.setValue(response.data);
        }).catch(function (error) {
            //alert("error:"+error+"hola");
        });

};