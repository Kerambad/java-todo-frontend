import React, {useEffect, useState} from 'react';
import './App.css';
import axios from "axios";
import ToDoGallery from "./components/ToDoGallery";
import {Simulate} from "react-dom/test-utils";
import error = Simulate.error;

function App() {

    const [toDos, setToDos] = useState([])
    const [toAdd, setToAdd] = useState("");

    useEffect(() => {
        axios.get("/api/todo")
            .then((response) => {
                return response.data
            })
            .then((data) => setToDos(data))
            .catch((error) => console.error())
    }, [])

    return (
        <>
            <div className="App-header">
                <ToDoGallery toDoGallery={toDos}/>
            </div>

            <div className="add-field">
                <input type={"text"} onChange={(input) => setToAdd(input.target.value)}/>
                <button onClick={() => {axios.post("/api/todo", {id: "", description: toAdd, status: `OPEN`})}}>Add To-Do</button>
            </div>
        </>
    );
}

export default App;
