import { Route, Routes } from 'react-router-dom';
import Home from '@/pages/Home.tsx';
import HomeLayout from '@/components/layout/HomeLayout.tsx';
import Login from '@/pages/Login.tsx';
import SignUp from '@/pages/SignUp.tsx';
import Spaces from '@/pages/Spaces.tsx';
import SpaceLayout from '@/components/layout/SpaceLayout.tsx';

const App = () => {
  return (
    <>
      <Routes>
        <Route path="/" element={<HomeLayout />}>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<SignUp />} />
        </Route>
        <Route path="/spaces" element={<Spaces />} />
        <Route path="/spaces/:spaceId" element={<SpaceLayout />}></Route>
      </Routes>
    </>
  );
};

export default App;
