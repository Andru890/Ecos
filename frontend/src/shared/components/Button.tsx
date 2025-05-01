import { ReactNode, MouseEventHandler } from "react";

interface ButtonProps {
  children: ReactNode;
  onClick?: MouseEventHandler<HTMLButtonElement>;
  type?: "button" | "submit" | "reset";
  className?: string;
  disabled?: boolean;
}

const Button = ({ children, onClick, type = "button", className = "" }: ButtonProps) => {
  return (
    <button
      onClick={onClick}
      type={type}
      className={`h-[50px] w-full rounded-[27px] border border-solid border-[#ECE6F0] bg-[#B4B4B4] px-4 py-2 text-[#291117] ${className}`}
    >
      {children}
    </button>
  );
};

export default Button;
