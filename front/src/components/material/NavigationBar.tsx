import { AppBar, Button, Toolbar, Typography } from '@mui/material';

const NavigationBar = () => {
  return (
    <div>
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" sx={{ flexGrow: 1 }}>
            Kiwi
          </Typography>
          <Button color="inherit">Home</Button>
          <Button color="inherit">About</Button>
          <Button color="inherit">Contact us</Button>
        </Toolbar>
      </AppBar>
    </div>
  );
};

export default NavigationBar;
