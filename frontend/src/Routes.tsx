import { BrowserRouter as Router, Route, Switch } from "react-router-dom"
import Home from "pages/Home"
import Dashboard from "pages/Dashboard"

const Routes = () => {
  return (
    <Router>
      <Switch>
        <Route path="/" exact>
          <Home />
        </Route>
        <Route path="/dashboard" exact>
          <Dashboard />
        </Route>
      </Switch>
    </Router>
  )
}

export default Routes
