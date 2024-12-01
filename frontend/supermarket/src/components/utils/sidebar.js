function Sidebar({ isOpen, toggleSidebar, children, className, side='right' }) {
    return <div className={`fixed px-5 py-2 top-0 ${side==='right' ? 'right-0' : 'left-0'} w-1/3 h-full bg-white shadow-lg transition-transform transform duration-300 ${isOpen ? 'translate-x-0' : `${side==='right' ? 'translate-x-full' : 'translate-x-[-100%]'}`} ${className}`}>
        <button className="text-4xl text-gray-500" onClick={toggleSidebar}>&times;</button>
        <div>{children}</div>
    </div>;
}

export default Sidebar;