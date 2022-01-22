import React, {useState,useReducer} from "react";

const ReducerHookDemo = () => {
    /*
    // without using Reducer
    const[count,setCount] = useState(0);
    const[showCounter,setShowCounter] = useState(true);
    return (
        <div>
            <h1> {count} </h1>
            <button 
            onClick = {() => {
                setCount(count + 1);
                setShowCounter(!showCounter)
            }}
            >
                Click Here
            </button>

            { showCounter && <p> Count Value is : {count}</p> }
        </div>


    ); */

    const reducer = (state,action) => {

        switch(action.type){
            case "Increment" : 
                return {count : state.count+1, showCounter : state.showCounter}
            case "toggleShowCount" :
                return {count : state.count, showCounter : !state.showCounter}
            case "Decrement" : 
                return {count : state.count-1, showCounter : state.showCounter}
            
            default:
                return state
        }

    };
    const [state,dispatch] = useReducer(reducer, {count: 0,showCounter:true})
   
    return (
        <div>
            <h1> {state.count} </h1>
            <button 
            onClick = {() => {
                dispatch({type :"Increment"});
                dispatch({type :"toggleShowCount"});

            }}
            >
                Increment Count
            </button>
            <br/>
            <br/>
            <button 
            onClick = {() => {
                dispatch({type :"Decrement"});
                dispatch({type :"toggleShowCount"});

            }}
            >
                Decrement Count
            </button>

            { state.showCounter && <p> Count Value is : {state.count}</p> }
        </div>


    ); 

};

export default ReducerHookDemo;