import { Route, Routes } from 'react-router-dom';
import { Home } from '@/pages/Home.tsx';
import { PageLayout } from '@/components/layout/PageLayout.tsx';

const App = () => {
  return (
    <>
      <Routes>
        <Route path="/" element={<PageLayout />}>
          <Route path="home" element={<Home />} />
        </Route>
      </Routes>
    </>
  );
};

export default App;
