import { ChakraProvider, extendTheme } from '@chakra-ui/react';
import { BrowserRouter } from 'react-router-dom';
import { colors, config } from './theme.js';
import Router from './components/Router.jsx';
import Layout from './components/layout/index.jsx';
import { QueryClient, QueryClientProvider } from 'react-query'
import { AuthProvider } from './providers/AuthProvider.jsx';

const theme = extendTheme({ colors, config });
const queryClient = new QueryClient(
  {
    defaultOptions: {
      queries: {
        retry: true,
      }
    }
  }
);

function App() {
  return (
        <ChakraProvider theme={theme}>
          <AuthProvider>
            <BrowserRouter>
              <Layout>
                <QueryClientProvider client={queryClient}>
                  <Router />
                </QueryClientProvider>
              </Layout>
            </BrowserRouter>
          </AuthProvider>
        </ChakraProvider>

  );
}

export default App;