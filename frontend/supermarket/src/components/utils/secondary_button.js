function SecondaryButton({ icon, label, id, onClick }) {
  return (
    <button id={id} className="w-full py-2 px-4 bg-[#232222] text-white border border-[#828282] hover:border-[#959AF9] hover:text-[#959AF9] rounded-md flex items-center justify-start" onClick={onClick}>
      <img src={icon.src} alt={icon.alt} className="w-4 h-4 mr-2 align-start" />
      <span className="flex-1">{label}</span>
    </button>
  );
}

export default SecondaryButton;
