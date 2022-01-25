import axios from "axios";
import React, {useState,useEffect} from "react";

const EffectHookDemo = () => {
    
    const[usersList, setUsersList]= useState([]);

    useEffect(() => {
            console.log("Fetch API gets called...")
            fetch(`https://api.github.com/users`)
            .then((response) => 
                    response.json())
                    .then(setUsersList);
            },[]);

   
    if(usersList){

        return (
            <ul>
                {
                    usersList.map((user) => (
                        <li key={user.id}>{user.login}</li>
                    ))
                }
            </ul>
            
        );

    }




};

export default EffectHookDemo;