import React from "react";
import './App.css';

function App() {
    return (
        <>
            <Header />
            <Body />
        </>
    )
}

export default App;

function Header() {
    return (
        <>
            <title>Mini URL</title>
            <h1>Mini URL</h1>
            <h4>A URL Shortening Application</h4>
        </>
    );
}

function Body() {
    return (
        <>
            <div className="textinput-with-button">
                <input type="text" name="longUrl" id="longUrl" size="100" />
                <button onClick={shortenLongUrl}>Shorten</button>
            </div>
            <div className="textinput-with-button">
                <input type="text" name="shortUrl" id="shortUrl" readOnly size="100" />
                <button onClick={copyShorturl}> Copy</button>
            </div>
        </>
    );
}

function copyShorturl() {
    let shortUrl = document.getElementById("shortUrl").value;
    navigator.clipboard.writeText(shortUrl).then(() => {
        alert("Short URL copied : "+shortUrl);
    });
}

function shortenLongUrl(){
    let longUrl = document.getElementById("longUrl").value;
    fetch(process.env.REACT_APP_SHORTENING_SERVICE_ENDPOINT,{
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "longUrl": longUrl
        })
    }).then(response => {
        return response.text()        
    }).then(data => {
        document.getElementById("shortUrl").value = data;
    }).catch(error=>{
        console.log(error);
    })
}