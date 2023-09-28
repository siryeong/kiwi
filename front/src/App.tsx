import { Route, Routes } from 'react-router-dom';
import { Home } from '@/pages/Home.tsx';
import { PageLayout } from '@/components/layout/PageLayout.tsx';
import { Login } from '@/pages/Login.tsx';
import { SignUp } from '@/pages/SignUp.tsx';

const App = () => {
  return (
    <>
      <Routes>
        <Route path="/" element={<PageLayout />}>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<SignUp />} />
        </Route>
      </Routes>
    </>
  );
};

export default App;
