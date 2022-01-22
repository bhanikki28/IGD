# React Hooks

Types of React Hooks <br/>
    1. useState <br/>
    2. useEffect <br/>
    3. useReducer <br/>
    4. useCallBack <br/>
    5. useMemo <br/>

## useState 

    Declaring the state and modifying the state using useState() React Hook
    eg:
        let [count,setCount] = useState(0)
        above example, declares the state count and initialzing it to zero.
        Then using the setCount function, the state can be modified 
        Then the component can be rendered into App.js by
                      <StateHookDemo />

## useReducer 

    useReducer Hook is helpful if we need to update more than one state based on a actionType
    It has dispatcher and reduce function to modify the state based on the actionType been passed to the function


##  useEffect

    useEffect React Hook is to do sideEffect and to fetch data, whenever state changes. It will get called whenever component mounted (initially), component got changed and component got released. Also, dependency can be added for which state, useEffect should be hooked.

        1. componentDidMount
        2. componentDidUpdate
        3. componentDidRelease




## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can't go back!**

If you aren't satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you're on your own.

You don't have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn't feel obligated to use this feature. However we understand that this tool wouldn't be useful if you couldn't customize it when you are ready for it.


