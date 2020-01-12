console.log(FileReader)
if(FileReader) {
    const reader = new FileReader()
    let filePath = './target.jsx'
    
    const string = reader.readAsText(filePath)
    console.log(string)
} else {
    console.log('unsupport FileReader')
}
// const file = document.