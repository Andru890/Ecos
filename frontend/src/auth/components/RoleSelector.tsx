import image from "@/assets/image.webp";
import Button from "@/shared/components/Button";
import { useState } from "react";
import RegistrationForm from "./RegistrationForm";

interface RoleSelectorProps {
  onChange: () => void;
}

const RoleSelector = ({ onChange }: RoleSelectorProps) => {
  const [showRegistrationForm, setShowRegistrationForm] = useState(false);
  const [role, setRole] = useState("");

  const handleRoleSelection = (role: string) => {
    setRole(role);
    setShowRegistrationForm(true);
  };

  return (
    <>
      {!showRegistrationForm ? (
        <div className="flex h-full flex-col items-center justify-around p-12">
          <div className="flex w-full items-center justify-around gap-12">
            <img src={image} alt="image" className="h-[120px] rounded-[16px]" />
            <div className="flex flex-col items-start justify-between gap-4">
              <Button
                type="button"
                className="bg-transparent font-bold"
                onClick={() => {
                  handleRoleSelection("FAN");
                }}
              >
                Registrate como Fan
              </Button>
              <p className="text-[#49454F]">
                Description duis aute irure dolor in reprehenderit in voluptate velit. <br />
                Description duis aute irure dolor in reprehenderit in voluptate velit.
              </p>
            </div>
          </div>

          <div className="flex w-full items-center justify-around gap-10">
            <img src={image} alt="image" className="h-[120px] rounded-[16px]" />
            <div className="flex flex-col items-start justify-between gap-4">
              <Button
                type="button"
                className="bg-transparent font-bold"
                onClick={() => {
                  handleRoleSelection("MUSICIAN");
                }}
              >
                Registrate como Músico
              </Button>
              <p className="text-[#49454F]">
                Description duis aute irure dolor in reprehenderit in voluptate velit. <br />
                Description duis aute irure dolor in reprehenderit in voluptate velit.
              </p>
            </div>
          </div>
        </div>
      ) : (
        <div className="flex h-full flex-col items-center justify-center">
          <RegistrationForm role={role} />
          <p className="mt-4 text-center text-sm">
            ¿Ya tienes cuenta?{" "}
            <u onClick={onChange} className="hover:cursor-pointer">
              Inicia sesión
            </u>
          </p>
        </div>
      )}
    </>
  );
};

export default RoleSelector;
