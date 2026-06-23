import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "./pages/Home";
import Cars from "./pages/Cars";
import CarDetails from "./pages/CarDetails";

import BuyNow from "./pages/BuyNow";
import Payment from "./pages/Payment";
import ServiceBooking from "./pages/ServiceBooking";
import TestDriveBooking from "./pages/TestDriveBooking";

import Contact from "./pages/Contact";

import Dashboard from "./admin/Dashboard";
import Settings from "./admin/Settings";

import Auth from "./pages/Auth";
import CarList from "./components/CarList";
import AdminRoute from "./routes/AdminRoute";

// 👤 USER PAGES
import MyProfile from "./pages/MyProfile";
import MyBookings from "./pages/MyBookings";
import Wishlist from "./pages/Wishlist";
import UserSettings from "./pages/UserSettings";

function App() {
  return (
    <BrowserRouter>
      <Routes>

        {/* 🔐 AUTH */}
        <Route path="/" element={<Auth />} />

        {/* 🚗 USER PAGES */}
        <Route path="/home" element={<Home />} />
        <Route path="/cars" element={<Cars />} />
        <Route path="/car/:id" element={<CarDetails />} />

        {/* 💰 USER ACTIONS */}
        <Route path="/buy" element={<BuyNow />} />
        <Route path="/payment" element={<Payment />} />
        <Route path="/service-booking" element={<ServiceBooking />} />
        <Route path="/test-drive" element={<TestDriveBooking />} />

        {/* 📞 CONTACT */}
        <Route path="/contact" element={<Contact />} />

        {/* 👤 PROFILE SECTION */}
        <Route path="/profile" element={<MyProfile />} />
        <Route path="/bookings" element={<MyBookings />} />
        <Route path="/wishlist" element={<Wishlist />} />
        <Route path="/user-settings" element={<UserSettings />} />

        {/* 🔐 ADMIN */}
        <Route
          path="/admin"
          element={
            <AdminRoute>
              <Dashboard />
            </AdminRoute>
          }
        />

        <Route
          path="/carlist"
          element={
            <AdminRoute>
              <CarList />
            </AdminRoute>
          }
        />

        <Route
          path="/settings"
          element={
            <AdminRoute>
              <Settings />
            </AdminRoute>
          }
        />

      </Routes>
    </BrowserRouter>
  );
}

export default App;
