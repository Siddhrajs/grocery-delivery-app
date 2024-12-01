import {DotLottieReact} from "@lottiefiles/dotlottie-react";
import { useState } from "react";
import PrimaryButton from "../components/utils/primary_button";
import Sidebar from "../components/utils/sidebar";
import LoginForm from "../components/login_form";

function HeroPage() {
    const [isSidebarOpen, setIsSidebarOpen] = useState(false);
    const animationSrc = "https://lottie.host/6c116724-a40f-4dce-a095-ee8f99a0d614/U6KvxCj2nj.lottie";

    const toggleSidebar = () => {
        setIsSidebarOpen(!isSidebarOpen);
    }

  return <div className="flex items-center justify-start h-screen bg-primary">
    <DotLottieReact
      className="h-1/2"
      src={animationSrc}
      loop
      autoplay
    />
    <PrimaryButton label="Sign in" onClick={toggleSidebar} />

    <Sidebar isOpen={isSidebarOpen} toggleSidebar={toggleSidebar}>
        <LoginForm />
    </Sidebar>
  </div>;
}

export default HeroPage;
