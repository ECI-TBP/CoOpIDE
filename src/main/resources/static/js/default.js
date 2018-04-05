var editor = ace.edit("editor");
editor.setTheme("ace/theme/dracula");
editor.session.setMode("ace/mode/java");

function textCapture() {
    console.log(editor.getValue());
}