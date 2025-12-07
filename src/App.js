import './App.css';
import Navbar from './components/Navbar/Navbar';
import { ThemeProvider } from '@emotion/react';
import { darkTheme } from './Theme/DarkTheme';
import { CssBaseline } from '@mui/material';
import Home from './components/Home/Home';
import ShopDetail from './components/Shop/ShopDetail';
import Cart from './components/Cart/Cart';

function App() {
  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline/>
     <Navbar/>
     {/*<Home/>*/}
     {/*<ShopDetail/>*/}
     <Cart/>
    </ThemeProvider>
  );
}

export default App;
